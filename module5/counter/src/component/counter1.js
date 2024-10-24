import React from 'react';
import useIncrement from './useIncrement';

function Counter1() {
    const [count, setCount] = useIncrement(1);

    return (
        <div>
            <h2>Counter 1: {count}</h2>
            <button onClick={setCount}>Increase Counter 1</button>
        </div>
    );
}

export default Counter1;