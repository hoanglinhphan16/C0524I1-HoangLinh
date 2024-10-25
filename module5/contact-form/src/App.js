import logo from './logo.svg';
import './App.css';
import { Link, Route, Routes } from 'react-router-dom';
import ContactForm from './ContactForm';
import MedicalForm from './MedicalForm';


function App() {
  return (
    <div className="App">
      <ul >
        <li>
          <Link to="/contact-form">Contact Form</Link>
        </li>
        <li>
          <Link to="/medical-form">Medical Form</Link>
        </li>
      </ul>
      <Routes>
        <Route path="/contact-form" element={<ContactForm />}></Route>
        <Route path="/medical-form" element={<MedicalForm />}></Route>
      </Routes>
    </div>
  );
}

export default App;
