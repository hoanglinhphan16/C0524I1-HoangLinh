import React, { useEffect, useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Table, Button } from 'react-bootstrap';
import { Formik, Form, Field } from "formik";
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

const BookManagement = () => {
    const [books, setBooks] = useState([]);
    const navigate = useNavigate();
    const [bookTypes, setBookTypes] = useState([]);
    const [notFound, setNotFound] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            const res = await axios.get(`http://localhost:3030/books?_sort=quantity&_order=desc`);
            setBooks(res.data)
        }

        fetchData();
    }, [])

    useEffect(() => {
        const fetchBookType = async () => {
            const res = await axios.get(`http://localhost:3030/bookType`)
            setBookTypes(res.data)
        }

        fetchBookType()
    }, [])

    const handleAdd = () => {
        navigate("/add");
    }

    const handleSearch = async (value) => {
        let query = 'http://localhost:3030/books?';

        let queryParams = [];

        if (value.name !== '') {
            queryParams.push(`name_like=${value.name}`);
        }
        if (value.bookTypeId !== '') {
            queryParams.push(`bookType.id=${value.bookTypeId}`);
        }

        if (queryParams.length > 0) {
            query += queryParams.join('&');
        }

        try {
            const response = await axios.get(query);
            if (response.data.length === 0) {
                setNotFound(true);
            } else {
                setBooks(response.data);
                setNotFound(false);
            };
        } catch (error) {
            console.error('Lỗi khi tìm kiếm:', error);
        }
    };


    return (

        <div className="container mt-5">
            <div className="row mb-4">
                <h2 className="text-center col-md-9 ">Quản lý sách</h2>
                <div className='col-md-3'>
                    <Button onClick={handleAdd} type="submit" className="form-control col-md-4" variant="outline-success">Thêm mới sách</Button>
                </div>
            </div>
            <Formik
                initialValues={{
                    name: "",
                    bookTypeId: "",
                }}
                onSubmit={value => handleSearch(value)}
            >
                <Form className="row mb-3">
                    <div className="col-md-4">
                        <Field className="form-control" name="name" placeholder="Tên sách" />
                    </div>

                    <div className="col-md-4">
                        <Field
                            as="select"
                            id="bookTypeId"
                            name="bookTypeId"
                            className="form-select">
                            <option value="" disabled>Chọn thể loại</option>
                            {bookTypes.map(bookType => (
                                <option key={bookType.id} value={bookType.id}>
                                    {bookType.name}
                                </option>
                            ))}
                        </Field>
                    </div>
                    <div className="col-md-4">
                        <Button type="submit" className="form-control" variant="outline-warning">Tìm kiếm</Button>
                    </div>
                </Form>
            </Formik>
            {notFound
                ? <div className='text-uppercase fs-1 fw-bold text-danger'>Không có sách bạn đang tìm kiếm</div>
                : <Table variant="warning" striped bordered hover className="table table-bordered">
                    <thead>
                        <tr className='bg-yellow'>
                            <th>Mã số sách</th>
                            <th>Tên sách</th>
                            <th>Thể loại</th>
                            <th>Ngày nhập sách</th>
                            <th>Số lượng</th>
                            <th>Detail</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        {books.map((book) => (
                            <tr key={book.id}>
                                <td>{book.id}</td>
                                <td>{book.name}</td>
                                <td>{book.bookType.name}</td>
                                <td>{new Date(book.dateIn).toLocaleDateString('vi-VN')}</td>
                                <td>{book.quantity}</td>
                                <td>
                                    <Button className="btn btn-info">Xem</Button>
                                </td>
                                <td>
                                    <Button className="btn btn-danger">Xóa</Button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </Table>}
        </div>
    );
};

export default BookManagement;
