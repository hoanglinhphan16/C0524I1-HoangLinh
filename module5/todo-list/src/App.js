import logo from './logo.svg';
import './App.css';
import React, { Component } from 'react';
import "bootstrap/dist/css/bootstrap.css";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      list: [],
      item: ''
    }
  }

  handleChange = (event) => {
    this.setState({ item: event.target.value });
  }

  handleAdd = () => {
    if (!this.state.list.includes(this.state.item)) {
      this.setState((prevState) => ({
        list: [...prevState.list, this.state.item]
      }), () => {
        console.log('Updated list:', this.state.list);
      });
    } else console.log("Existed!!!");

  }

  render() {
    return (<div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <h2>
          Todo List
        </h2>

        <div className='d-flex'>
          <input type="text" onChange={this.handleChange} />
          <button onClick={this.handleAdd} className="btn btn-primary">Add</button>
        </div>

        {this.state.list.map(e => (
          <p>{e}</p>
        ))}
      </header>
    </div>);
  }
}

export default App;
