import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from "react-redux";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Table, Button } from 'react-bootstrap';
import { Formik, Form, Field, ErrorMessage } from "formik";
import { fetchOrigin, fetchPig, searchPig } from '../redux/action';
import { useNavigate } from 'react-router-dom';
import ModalDetail from './ModalEdit';
import ModalDelete from './ModalDelete';
import Pagination from 'react-bootstrap/Pagination';
import axios from 'axios';

const PigManagement = () => {
    const limit = 5;
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const origins = useSelector(state => state.origins)
    const pigs = useSelector(state => state.pigs);
    const [modalShow, setModalShow] = useState(false);
    const [modalDelete, setModalDelete] = useState(false);
    const [pig, setPig] = useState({});
    const [currentPage, setCurrentPage] = useState(1);
    const totalPages = useSelector(state => state.totalPages)

    useEffect(() => {
        dispatch(fetchOrigin());
    }, [origins])

    useEffect(() => {
        dispatch(fetchPig(currentPage, limit));
    }, [currentPage]);

    const handleSubmit = (values) => {
        console.log('Form values:', values);
    };

    const handleAdd = () => {
        navigate("/add");
    }

    const handleEditPig = (pig) => {
        setPig(pig);
        setModalShow(true);
    }

    const handleDeletePig = (pig) => {
        setPig(pig);
        setModalDelete(true);
    }

    const handlePageChange = (page) => {
        if (page >= 1 && page <= totalPages) {
            setCurrentPage(page);
        }
    };

    const handleSearch = async (value) => {
        dispatch(searchPig(value, currentPage, limit));
    };

    return (
        <div className="container mt-5">
            <div className="row mb-4">
                <h2 className="text-center col-md-9 ">Quản lý heo</h2>
                <div className='col-md-3'>
                    <Button onClick={handleAdd} type="submit" className="form-control col-md-4" variant="outline-success">Thêm mới heo</Button>
                </div>
            </div>
            <Formik
                initialValues={{
                    pigStatus: "",
                    pigId: "",
                    originId: "",
                }}
                onSubmit={value => handleSearch(value)}
            >
                <Form className="row mb-3">
                    <div className="col-md-3">
                        <Field as="select" name="pigStatus" className="form-select">
                            <option value="" disabled>Chọn tình trạng</option>
                            <option value="Đã bán">Đã bán</option>
                            <option value="Chưa bán">Chưa bán</option>
                        </Field>
                    </div>

                    <div className="col-md-3">
                        <Field className="form-control" name="pigId" placeholder="Mã heo" />
                        <ErrorMessage name="pigId" component="div" style={{ color: 'red' }} />
                    </div>

                    <div className="col-md-3">
                        <Field
                            as="select"
                            id="originId"
                            name="originId"
                            className="form-select">
                            <option value="" disabled>Chọn xuất xứ</option>
                            {origins.map(origin => (
                                <option key={origin.id} value={origin.id}>
                                    {origin.country}
                                </option>
                            ))}
                        </Field>
                    </div>
                    <div className="col-md-3">
                        <Button type="submit" className="form-control" variant="outline-warning">Submit</Button>
                    </div>
                </Form>
            </Formik>

            <Table variant="warning" striped bordered hover className="table table-bordered">
                <thead>
                    <tr className='bg-yellow'>
                        <th>Mã số heo</th>
                        <th>Ngày nhập chuồng</th>
                        <th>Trọng lượng khi nhập chuồng</th>
                        <th>Thời gian xuất chuồng</th>
                        <th>Trọng lượng khi xuất chuồng</th>
                        <th>Xuất xứ</th>
                        <th>Xuất chuồng</th>
                        <th>Detail</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    {pigs.map((pig) => (
                        <tr key={pig.id}>
                            <td>{pig.id}</td>
                            <td>{pig.dateIn}</td>
                            <td>{pig.weightIn} kg</td>
                            <td>{pig.dateOut}</td>
                            <td>{pig.weightOut} kg</td>
                            <td>{pig.origin.country}</td>
                            <td>{pig.status}</td>
                            <td>
                                <Button className="btn btn-info" onClick={() => handleEditPig(pig)}>Xem</Button>
                            </td>
                            <td>
                                <Button className="btn btn-danger" onClick={() => handleDeletePig(pig)}>Xóa</Button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </Table>
            <Pagination>
                <Pagination.Prev
                    onClick={() => handlePageChange(currentPage - 1)}
                    disabled={currentPage === 1}
                />
                {[...Array(totalPages).keys()].map((pageNumber) => (
                    <Pagination.Item
                        key={pageNumber + 1}
                        active={pageNumber + 1 === currentPage}
                        onClick={() => handlePageChange(pageNumber + 1)}
                    >
                        {pageNumber + 1}
                    </Pagination.Item>
                ))}
                <Pagination.Next
                    onClick={() => handlePageChange(currentPage + 1)}
                    disabled={currentPage === totalPages}
                />
            </Pagination>

            <ModalDetail show={modalShow} onHide={() => setModalShow(false)} pig={pig} />
            <ModalDelete show={modalDelete} onHide={() => setModalDelete(false)} pig={pig} />
        </div>
    );
};

export default PigManagement;
