import React, { useEffect, useState } from 'react';
import { Table, Button, Container, Row, Col } from 'react-bootstrap';
import "bootstrap/dist/css/bootstrap.css";
import './App.css';
import axios from 'axios';
import BookDetail from './BookDetail';

const Library = () => {
  const [books, setBooks] = useState([]);
  const [modalShow, setModalShow] = useState(false);
  const [bookDetail, setBookDetail] = useState({});
  // const [isCreate, setIsCreate] = useState(false);

  useEffect(() => {
    fetchData()
  }, [books])

  const fetchData = async () => {
    const res = await axios.get(`http://localhost:8080/books`)
    setBooks(res.data)
  }

  const handleDelete = async (id) => {
    try {
      const res = await (axios.delete(`http://localhost:8080/books/${id}`))
      console.log(res);

    } catch (error) {
      console.log(error);
    }
  };

  const handleBookDetail = (bookId) => {
    setModalShow(true);
    const book = books.find(e => e.id === bookId)
    setBookDetail(book);
  }

  const handleSaveSuccess = () => {
    setModalShow(false);
    fetchData();
  };

  const handleCreateNewBook = () => {
    setModalShow(true);
    setBookDetail(null);
  }

  return (
    <Container className="mt-4">
      <Row className="mb-3">
        <Col>
          <h2 className="title">Library</h2>
        </Col>
        <Col className="text-end">
          <Button className="add-button" onClick={handleCreateNewBook}>Add a new Book</Button>
        </Col>
      </Row>
      <Table bordered hover className="custom-table">
        <thead>
          <tr>
            <th>Title</th>
            <th>Quantity</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {books.map(book => (
            <tr key={book.id}>
              <td>{book.title}</td>
              <td>{book.quantity}</td>
              <td>
                <Button className="btn-edit me-2" onClick={() => handleBookDetail(book.id)}>Edit</Button>
                <Button className="btn-delete" onClick={() => handleDelete(book.id)}>Delete</Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
      <BookDetail book={bookDetail} show={modalShow} onHide={() => setModalShow(false)} onSaveSuccess={handleSaveSuccess} />
    </Container>
  );
};

export default Library;
