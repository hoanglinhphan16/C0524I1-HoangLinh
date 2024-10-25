import React from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";

const ValidateForm = Yup.object().shape({
    name: Yup.string().required("Required"),
    email: Yup.string().required("Required").matches(/^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/, "Không đúng định dạng"),
    phone: Yup.string().required("Required")
});

const ContactForm = () => {
    return (
        <>
            <Formik
                initialValues={{
                    name: "",
                    email: "",
                    phone: "",
                    message: "",
                }}
                validationSchema={ValidateForm}
                onSubmit={(values) => console.log(values)}
            >
                <Form>
                    <label htmlFor="name">Name</label>
                    <Field name="name" />
                    <ErrorMessage name="name" component="div" style={{ color: 'red' }} />

                    <label htmlFor="email">Email</label>
                    <Field name="email" />
                    <ErrorMessage name="email" component="div" style={{ color: 'red' }} />

                    <label htmlFor="phone">Phone</label>
                    <Field name="phone" type="phone" />
                    <ErrorMessage name="phone" component="div" style={{ color: 'red' }} />

                    <label htmlFor="phone">Message</label>
                    <Field type="textarea" name="message" />
                    <button type="submit">Submit</button>
                </Form>
            </Formik></>
    )
}

export default ContactForm;