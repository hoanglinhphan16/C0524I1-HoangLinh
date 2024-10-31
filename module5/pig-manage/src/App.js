import logo from './logo.svg';
import './App.css';
import { Provider } from "react-redux";
import store from "./redux/store";
import { Routes, Route, BrowserRouter } from 'react-router-dom'
import PigManagement from './components/ListPig';
import { AddPig } from './components/AddPig';
import 'react-toastify/dist/ReactToastify.css';
import { ToastContainer } from 'react-toastify';

function App() {
  return (
    <Provider store={store}>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<PigManagement />} />
          <Route path="/add" element={<AddPig />} />
        </Routes>
      </BrowserRouter>
      <ToastContainer />
    </Provider>
  );
}

export default App;
