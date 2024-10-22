import './index.css';
import React, { Component } from 'react';
import students from './listStudent';

function ListStd() {
    return (
        <div>
            <hr />
            <div class="container table-container">
                <h2 class="text-center my-4">Company Information</h2>
                <table class="table table-hover table-bordered">
                    <thead>
                        <tr>
                            <th>Company</th>
                            <th>Contact</th>
                            <th>Country</th>
                        </tr>
                    </thead>
                    <tbody>
                        {students.map(student => (
                            <tr>
                                <td>{student.company}</td>
                                <td>{student.contact}</td>
                                <td>{student.country}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
            <hr />
        </div>
    )
}

export default ListStd;