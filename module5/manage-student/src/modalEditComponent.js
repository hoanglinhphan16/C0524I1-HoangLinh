import React, { useEffect, useState } from "react";
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap/dist/js/bootstrap";

const EditStudentModal = ({ show, student, onClose, onSave }) => {
    const [editedStudent, setEditedStudent] = useState({});

    useEffect(() => {
        if (student) {
            setEditedStudent({ ...student });
        }
    }, [student]);

    const handleChange = (e) => {
        setEditedStudent({
            ...editedStudent,
            [e.target.name]: e.target.value,
        });
    };

    if (!show) {
        return null;
    }

    return (
        <div className="container d-flex align-items-center text-center mt-5">
            <div className="form">
                <div className="form-control">
                    <h2>Edit Student</h2>
                    <form>
                        <label>Name:</label>
                        <input
                            type="text"
                            name="name"
                            value={editedStudent.name}
                            onChange={handleChange}
                        />

                        <label>Phone:</label>
                        <input
                            type="number"
                            name="email"
                            value={editedStudent.phone}
                            onChange={handleChange}
                        />

                        <label>Email:</label>
                        <input
                            type="email"
                            name="email"
                            value={editedStudent.email}
                            onChange={handleChange}
                        />

                        <button type="button" className="btn btn-success" onClick={() => onSave(editedStudent)}>
                            Save
                        </button>
                        <button type="button" className="btn btn-danger" onClick={onClose}>
                            Cancel
                        </button>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default EditStudentModal;