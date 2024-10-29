import logo from './logo.svg';
import './App.css';
import { Provider } from "react-redux";
import store from "./redux/store";
import PigManagement from './components/ListPig';

function App() {
  return (
    <Provider store={store}>
      {/* <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/users" element={<User />} />
        </Routes>
      </BrowserRouter> */}
      <PigManagement />
    </Provider>
  );
}

export default App;
