import React, { useEffect, useState } from "react";
import axios from "axios";

const TodoList = () => {
    const [todoList, setTodoList] = useState([]);
    const [item, setItem] = useState({})

    useEffect(() => {
        const fetchData = async () => {
            try {
                const res = await axios.get(`https://jsonplaceholder.typicode.com/todos`);
                setTodoList(res.data);
            } catch (error) {
                console.log(error);
            }
        };

        fetchData();
    }, [])

    const handleChange = async (event) => {
        setItem({ title: event.target.value })
    }

    const handleAdd = async () => {
        try {
            const res = await axios.post(`https://jsonplaceholder.typicode.com/todos`, item);
            setTodoList((preTodoList) => [
                ...preTodoList,
                res.data
            ])
        } catch (error) {
            console.log(error);
        }
    };

    return (
        <>
            <input type="text" onChange={handleChange} />
            <button onClick={handleAdd} className="btn btn-primary">Add</button>
            {todoList.map(e => (
                <ul key={e.id}>
                    <li>{e.title}</li>
                </ul>
            ))}
        </>
    )
}

export default TodoList;