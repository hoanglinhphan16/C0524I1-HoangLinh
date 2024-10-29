import axios from "axios";

export const FETCH_PIG = "FETCH_PIG";
export const FETCH_PIG_SUCCESS = "FETCH_PIG_SUCCESS";
export const FETCH_ORIGIN = "FETCH_ORIGIN";
export const FETCH_ORIGIN_SUCCESS = "FETCH_ORIGIN_SUCCESS"

export const fetchPig = () => {
    return async dispatch => {
        const res = await axios.get(`http://localhost:3030/pigs`);

        dispatch({
            type: FETCH_PIG_SUCCESS,
            payload: res.data
        })
    }
}

export const fetchOrigin = () => {
    return async dispatch => {
        const res = await axios.get(`http://localhost:3030/origins`);

        dispatch({
            type: FETCH_ORIGIN_SUCCESS,
            payload: res.data
        })
    }
}