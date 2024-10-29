import React, { useEffect } from 'react';
import { useDispatch, useSelector } from "react-redux";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Table, Button } from 'react-bootstrap';
import { Formik, Form, Field, ErrorMessage } from "formik";
import { fetchOrigin, fetchPig } from '../redux/action';

const PigManagement = () => {
    const dispatch = useDispatch();
    const origins = useSelector(state => state.origins)
    const pigs = useSelector(state => state.pigs);

    useEffect(() => {
        dispatch(fetchOrigin());
    }, [origins])

    useEffect(() => {
        dispatch(fetchPig());
    }, [pigs]);

    const handleSubmit = (values) => {
        console.log('Form values:', values);
    };

    return (
        <div className="container mt-5">
            <h2 className="text-center mb-4">Quản lý heo</h2>
            <Formik
                initialValues={{
                    pigStatus: "",
                    pigId: "",
                    originId: "",
                }}
                onSubmit={handleSubmit}
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
                            <td>{pig.code}</td>
                            <td>{pig.dateIn}</td>
                            <td>{pig.weightIn}</td>
                            <td>{pig.dateOut}</td>
                            <td>{pig.weightOut}</td>
                            <td>{pig.origin.country}</td>
                            <td>{pig.status}</td>
                            <td>
                                <Button className="btn btn-info">Xem</Button>
                            </td>
                            <td>
                                <Button className="btn btn-danger">Xóa</Button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </Table>
        </div>
    );
};

export default PigManagement;
