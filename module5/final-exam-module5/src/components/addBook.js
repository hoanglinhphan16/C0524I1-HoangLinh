import { useEffect, useState } from 'react';
import { Button } from 'react-bootstrap';
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';
import axios from 'axios';

const ValidateForm = Yup.object().shape({
    id: Yup.string()
        .matches(/^BO-\d{4}$/, "ID phải có định dạng BO-XXXX (X là các số)")
        .required("Required"),
    name: Yup.string()
        .max(100, "Name không được dài quá 100 ký tự")
        .required("Required"),
    dateIn: Yup.date()
        .max(new Date(), "Ngày nhập không được lớn hơn ngày hiện tại")
        .required("Required"),
    quantity: Yup.number()
        .integer("Quantity phải là số nguyên")
        .min(1, "Quantity phải lớn hơn 0")
        .required("Required")
});

export const AddBook = () => {
    const navigate = useNavigate();
    const [bookTypes, setBookTypes] = useState([]);

    useEffect(() => {
        const fetchBookType = async () => {
            const res = await axios.get(`http://localhost:3030/bookType`)
            setBookTypes(res.data)
        }

        fetchBookType()
    }, [])


    const handleSubmit = async (value) => {
        const bookType = bookTypes.find(bookType => bookType.id === value.bookTypeId);
        const data = {
            id: value.id,
            name: value.name,
            dateIn: value.dateIn,
            bookType: bookType,
            quantity: value.quantity,
        }

        const res = await axios.post(`http://localhost:3030/books`, data);

        if (res.status === 201) {
            toast.success('🦄 Add Success!', {
                position: "top-right",
                autoClose: 5000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
                theme: "light",
            });
            navigate("/")
        } else {
            toast.error('🦄 Something wrong!', {
                position: "top-right",
                autoClose: 5000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
                theme: "light",
            });
        }

    }

    return (
        <div className="container mt-5">
            <h2 className="text-center mb-4">Quản lý heo</h2>
            <Formik
                validationSchema={ValidateForm}
                initialValues={{
                    id: "",
                    name: "",
                    dateIn: "",
                    bookTypeId: "",
                    quantity: "",
                }}
                onSubmit={handleSubmit}>

                <Form>
                    <div className="mb-3">
                        <label htmlFor="id" className="form-label">Mã sách</label>
                        <Field type="text" id="id" name="id" className="form-control" required />
                        <ErrorMessage name="id" component="div" style={{ color: 'red' }} />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="name" className="form-label">Tên sách</label>
                        <Field type="text" id="name" name="name" className="form-control" required />
                        <ErrorMessage name="name" component="div" style={{ color: 'red' }} />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="bookTypeId" className="form-label">Thể loại</label>
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

                    <div className="mb-3">
                        <label htmlFor="dateIn" className="form-label">Ngày nhập sách</label>
                        <Field type="date" id="dateIn" name="dateIn" className="form-control" />
                        <ErrorMessage name="dateIn" component="div" style={{ color: 'red' }} />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="quantity" className="form-label">Số lượng</label>
                        <Field type="number" id="quantity" name="quantity" className="form-control" />
                        <ErrorMessage name="quantity" component="div" style={{ color: 'red' }} />
                    </div>


                    <div className="mb-3">
                        <Button type="submit" className="form-control" variant="outline-warning">Submit</Button>
                    </div>
                </Form>
            </Formik>
        </div>
    );
}

