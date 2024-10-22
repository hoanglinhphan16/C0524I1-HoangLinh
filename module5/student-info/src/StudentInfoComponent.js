import React from 'react';
import students from './listStudent';

class Student extends React.Component {
    render() {
        return (
            <div>
                <hr />
                <div className="container table-container">
                    <h2 className="text-center my-4">Company Information</h2>
                    <table className="table table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Age</th>
                                <th>Address</th>
                            </tr>
                        </thead>
                        <tbody>
                            {students.map(student => (
                                <tr key={student.id}>
                                    <td>{student.id}</td>
                                    <td>{student.name}</td>
                                    <td>{student.age}</td>
                                    <td>{student.address}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
                <hr />
            </div>
        )
    }
}

export default Student;