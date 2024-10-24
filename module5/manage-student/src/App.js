import logo from './logo.svg';
import './App.css';
import "bootstrap/dist/css/bootstrap.css";
import React, { useState, useEffect } from 'react';
import studentList from './listStudent';
import EditStudentModal from './modalEditComponent';

function App() {
  const [students, setStudents] = useState([]);
  const [newStudent, setNewStudent] = useState({
    id: '',
    name: '',
    email: '',
    phone: ''
  });
  const [studentEdit, setStudentEdit] = useState(null);
  const [showModal, setShowModal] = useState(false);
  useEffect(() => {
    setStudents(studentList);
  }, [])

  const handleAddStudent = () => {
    if (newStudent.name.trim() && newStudent.email.trim() && newStudent.phone.trim()) {
      const newId = students.length + 1;
      const studentToAdd = { ...newStudent, id: newId }
      setStudents((preStds) => [...preStds, studentToAdd]);
      setNewStudent({ id: '', name: '', email: '', phone: '' });
    }
  }

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setNewStudent((preStd) => ({
      ...preStd,
      [name]: value
    }))
  }

  const handleEditStudent = student => {
    console.log(student);

    setStudentEdit(student);
    setShowModal(true);
  }

  const handleCloseModal = () => {
    setShowModal(false);
    setStudentEdit(null);
  };

  const handleSaveStudent = (editedStudent) => {
    setStudents(students => students.map(student => student.id === editedStudent.id ? editedStudent : student));
    setShowModal(false);
  }

  const handleDeleteStudent = (id) => {
    const index = students.findIndex(student => student.id === id);

    if (index !== -1) {
      setStudents(students => students.filter(student => student.id !== id));
      console.log(`Deleted student with id: ${id}`);
    } else {
      console.log(`Student with id: ${id} not found`);
    }
  }

  return (
    <div>
      <h2 className="text-center my-4">Student List</h2>
      <div className="container d-flex align-items-center text-center mt-5">
        <div className="form-signin">
          <div className="form-floating">
            <input type="email" name="email" className="form-control email" value={newStudent.email} onChange={handleInputChange} />
            <label>Email address</label>
          </div>
          <div className="form-floating">
            <input type="text" name="name" className="form-control password" value={newStudent.name} onChange={handleInputChange} />
            <label>Name</label>
          </div>
          <div className="form-floating">
            <input type="number" name="phone" className="form-control email" value={newStudent.phone} onChange={handleInputChange} />
            <label>Phone</label>
          </div>
          <button className="w-100 btn btn-lg btn-primary" onClick={handleAddStudent} type="submit">Submit</button>
        </div>
      </div>
      <div className="container table-container mt-5">
        <table className="table table-hover table-bordered">
          <thead>
            <tr className='text-center'>
              <th>Name</th>
              <th>Phone</th>
              <th>Email</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {students.map(student => (
              <tr key={student.id}>
                <td>{student.name}</td>
                <td>{student.phone}</td>
                <td>{student.email}</td>
                <td className='d-flex justify-content-evenly'>
                  <button onClick={() => handleEditStudent(student)} type='button' className='btn btn-danger'>Edit</button>
                  <button onClick={() => handleDeleteStudent(student.id)} type='button' className='btn btn-danger'>Delete</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      <EditStudentModal
        show={showModal}
        student={studentEdit}
        onClose={handleCloseModal}
        onSave={handleSaveStudent}
      ></EditStudentModal>
    </div>
  );
}

export default App;
