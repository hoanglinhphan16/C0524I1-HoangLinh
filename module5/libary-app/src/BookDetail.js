import { useState, useEffect } from 'react';
import { Button, Form, Modal } from 'react-bootstrap';
import axios from 'axios';

function ModalDetail({ show, onHide, book, onSaveSuccess }) {
    const [formData, setFormData] = useState({
        title: "",
        quantity: 0,
    });

    useEffect(() => {
        if (book && show) {
            setFormData({
                title: book.title || "",
                quantity: book.quantity || 0,
            });
        } else {
            setFormData({
                title: "",
                quantity: 0,
            });
        }
    }, [book, show]);

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData(prevState => ({
            ...prevState,
            [name]: value,
        }));
    };

    const handleSave = async () => {
        try {
            if (book) {
                const res = await axios.put(`http://localhost:8080/books/${book.id}`, formData);
                if (res.status === 200) {
                    console.log("Cập nhật thành công");
                    onSaveSuccess();
                }
            } else {
                const res = await axios.post(`http://localhost:8080/books`, formData);
                if (res.status === 201) {
                    console.log("Tạo mới thành công");
                    onSaveSuccess();
                }
            }
        } catch (error) {
            console.log(error);
        }
    }

    return (
        <Modal show={show} onHide={onHide}>
            <Modal.Header closeButton>
                <Modal.Title>Modal heading</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Label>Title</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Enter title"
                            name="title"
                            value={formData.title}
                            onChange={handleInputChange}
                            autoFocus
                        />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                        <Form.Label>Quantity</Form.Label>
                        <Form.Control
                            type="number"
                            name="quantity"
                            value={formData.quantity}
                            onChange={handleInputChange}
                        />
                    </Form.Group>
                </Form>
            </Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={onHide}>
                    Close
                </Button>
                <Button variant="primary" onClick={handleSave}>
                    {book ? "Save Changes" : "Create Book"}
                </Button>
            </Modal.Footer>
        </Modal>
    );
}

export default ModalDetail;