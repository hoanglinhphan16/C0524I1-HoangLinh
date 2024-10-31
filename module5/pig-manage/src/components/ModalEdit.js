import { Modal, Button } from 'react-bootstrap';
import { Formik, Form, Field, ErrorMessage } from "formik";
import { useDispatch, useSelector } from "react-redux";
import { editPig } from '../redux/action';
import { toast } from 'react-toastify';

function ModalDetail({ show, onHide, pig }) {
    const dispatch = useDispatch();
    const origins = useSelector(state => state.origins);

    const handleSubmit = (value) => {
        const origin = origins.find(origin => origin.id === value.originId)
        const status = value.weightOut > value.weightIn ? "Đã bán" : "Chưa bán";

        const data = {
            id: value.id,
            dateIn: value.dateIn,
            weightIn: value.weightIn,
            dateOut: value.dateOut,
            weightOut: value.weightOut,
            origin: origin,
            status: status
        }

        dispatch(editPig(data));
        toast.success('🦄 Edit Success!', {
            position: "top-right",
            autoClose: 5000,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: true,
            draggable: true,
            progress: undefined,
            theme: "light",
        });
        onHide();
    };

    return (
        <Modal show={show} onHide={onHide} centered>
            <Modal.Header closeButton>
                <Modal.Title>Sửa thông tin heo có mã số {pig.id}</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Formik
                    initialValues={{
                        id: pig.id,
                        dateIn: pig.dateIn,
                        weightIn: pig.weightIn,
                        dateOut: pig.dateOut,
                        weightOut: pig.weightOut,
                        originId: pig?.origin?.id
                    }}
                    onSubmit={handleSubmit}>

                    <Form>
                        <div className="mb-3 d-none">
                            <label htmlFor="id" className="form-label">Mã Heo</label>
                            <Field type="text" id="id" name="id" className="form-control" required />
                            <ErrorMessage name="id" component="div" style={{ color: 'red' }} />
                        </div>

                        <div className="mb-3">
                            <label htmlFor="dateIn" className="form-label">Ngày nhập</label>
                            <Field type="date" id="dateIn" name="dateIn" className="form-control" required />
                            <ErrorMessage name="dateIn" component="div" style={{ color: 'red' }} />
                        </div>

                        <div className="mb-3">
                            <label htmlFor="weightIn" className="form-label">Trọng lượng khi nhập</label>
                            <Field type="number" id="weightIn" name="weightIn" className="form-control" required min="10" />
                            <ErrorMessage name="weightIn" component="div" style={{ color: 'red' }} />
                        </div>

                        <div className="mb-3">
                            <label htmlFor="dateOut" className="form-label">Ngày xuất</label>
                            <Field type="date" id="dateOut" name="dateOut" className="form-control" />
                            <ErrorMessage name="dateOut" component="div" style={{ color: 'red' }} />
                        </div>

                        <div className="mb-3">
                            <label htmlFor="weightOut" className="form-label">Trọng lượng khi xuất bán</label>
                            <Field type="number" id="weightOut" name="weightOut" className="form-control" min="10" />
                            <ErrorMessage name="weightOut" component="div" style={{ color: 'red' }} />
                        </div>

                        <div className="mb-3">
                            <label htmlFor="originId" className="form-label">Xuất xứ</label>
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
                        <div className="d-flex">
                            <Button type="submit" className="form-control" variant="outline-success">Submit</Button>
                        </div>
                    </Form>
                </Formik>
            </Modal.Body>
            {/* <Modal.Footer>
                <Button variant="secondary" onClick={onHide}>
                    Close
                </Button>
                <Button variant="primary">
                    Save
                </Button>
            </Modal.Footer> */}
        </Modal>
    );
}

export default ModalDetail;