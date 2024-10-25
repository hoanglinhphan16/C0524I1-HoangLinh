import React, { useState } from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";

const MedicalForm = () => {
    const [form, setForm] = useState({
        fullName: '',
        passportId: '',
        birthYear: '',
        gender: '',
        nationality: '',
        company: '',
        department: '',
        hasInsurance: false,
        province: '',
        district: '',
        ward: '',
        address: '',
        phone: '',
        email: '',
    })

    const validationSchema = Yup.object({
        fullName: Yup.string().required('Full name is required'),
        passportId: Yup.string().required('Passport/ID is required'),
        birthYear: Yup.number().required('Year of birth is required').positive().integer(),
        nationality: Yup.string().required('Nationality is required'),
        province: Yup.string().required('Province is required'),
        district: Yup.string().required('District is required'),
        ward: Yup.string().required('Ward is required'),
        address: Yup.string().required('Address is required'),
        phone: Yup.string().required('Phone number is required'),
        email: Yup.string().email('Invalid email format').required('Email is required'),
    });

    return (
        <Formik
            initialValues={form}
            validationSchema={validationSchema}
            onSubmit={(values) => {
                console.log(values);
            }}
        >
            <Form>
                <h2>Medical Declaration Form</h2>
                <div>
                    <label>Full Name</label>
                    <Field name="fullName" type="text" />
                    <ErrorMessage name="fullName" component="div" style={{ color: 'red' }} />
                </div>

                <div>
                    <label>Passport/ID</label>
                    <Field name="passportId" type="text" />
                    <ErrorMessage name="passportId" component="div" style={{ color: 'red' }} />
                </div>

                <div>
                    <label>Year of Birth</label>
                    <Field name="birthYear" type="number" />
                    <ErrorMessage name="birthYear" component="div" style={{ color: 'red' }} />
                </div>

                <div>
                    <label>Gender</label>
                    <div>
                        <Field type="radio" name="gender" value="male" />
                        Male
                        <Field type="radio" name="gender" value="female" />
                        Female
                    </div>
                </div>

                <div>
                    <label>Nationality</label>
                    <Field name="nationality" type="text" />
                    <ErrorMessage name="nationality" component="div" style={{ color: 'red' }} />
                </div>

                <div>
                    <label>Company</label>
                    <Field name="company" type="text" />
                </div>

                <div>
                    <label>Department</label>
                    <Field name="department" type="text" />
                </div>

                <div>
                    <label>
                        <Field type="checkbox" name="hasInsurance" />
                        Do you have health insurance?
                    </label>
                </div>

                <h3>Contact Information in Vietnam</h3>

                <div>
                    <label>Province</label>
                    <Field name="province" type="text" />
                    <ErrorMessage name="province" component="div" style={{ color: 'red' }} />
                </div>

                <div>
                    <label>District</label>
                    <Field name="district" type="text" />
                    <ErrorMessage name="district" component="div" style={{ color: 'red' }} />
                </div>

                <div>
                    <label>Ward</label>
                    <Field name="ward" type="text" />
                    <ErrorMessage name="ward" component="div" style={{ color: 'red' }} />
                </div>

                <div>
                    <label>Address</label>
                    <Field name="address" type="text" />
                    <ErrorMessage name="address" component="div" style={{ color: 'red' }} />
                </div>

                <div>
                    <label>Phone</label>
                    <Field name="phone" type="text" />
                    <ErrorMessage name="phone" component="div" style={{ color: 'red' }} />
                </div>

                <div>
                    <label>Email</label>
                    <Field name="email" type="email" />
                    <ErrorMessage name="email" component="div" style={{ color: 'red' }} />
                </div>

                <button type="submit">Submit</button>
            </Form>
        </Formik>
    )
}

export default MedicalForm;