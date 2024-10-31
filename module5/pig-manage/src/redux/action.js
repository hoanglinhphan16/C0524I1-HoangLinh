import axios from "axios";

export const FETCH_PIG_SUCCESS = "FETCH_PIG_SUCCESS";
export const FETCH_ORIGIN_SUCCESS = "FETCH_ORIGIN_SUCCESS";
export const ADD_PIG_SUCCESS = "ADD_PIG_SUCCESS";
export const EDIT_PIG_SUCCESS = "EDIT_PIG_SUCCESS";
export const DELETE_PIG_SUCCESS = "DELETE_PIG SUCCESS";
export const TOTAL_PAGES = "TOTAL_PAGES";
export const SEARCH_PIG = "SEARCH_PIG";

export const fetchPig = (currentPage, limit) => {
    return async dispatch => {
        const res = await axios.get(`http://localhost:3030/pigs?_page=${currentPage}&_limit=${limit}`);
        const totalItems = parseInt(res.headers['x-total-count'], 10);

        dispatch({
            type: FETCH_PIG_SUCCESS,
            payload: res.data
        })

        dispatch({
            type: TOTAL_PAGES,
            payload: Math.ceil(totalItems / limit)
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

export const addPig = (data) => {
    return async dispatch => {
        const res = await axios.post(`http://localhost:3030/pigs`, data);

        dispatch({
            type: ADD_PIG_SUCCESS,
            payload: res.data
        })
    }
}

export const editPig = (data) => {
    return async dispatch => {
        const res = await axios.put(`http://localhost:3030/pigs/${data.id}`, data);

        dispatch({
            type: EDIT_PIG_SUCCESS,
            payload: res.data
        })
    }
}

export const deletePig = (data) => {
    return async dispatch => {
        const res = await axios.delete(`http://localhost:3030/pigs/${data.id}`);

        dispatch({
            type: DELETE_PIG_SUCCESS,
            payload: res.data
        })
    }
}

export const searchPig = (data, currentPage, limit) => {
    return async dispatch => {
        let query = 'http://localhost:3030/pigs?';

        let queryParams = [];

        if (data.pigStatus !== '') {
            queryParams.push(`status=${data.pigStatus}`);
        }
        if (data.pigId !== '') {
            queryParams.push(`id=${data.pigId}`);
        }
        if (data.originId !== '') {
            queryParams.push(`origin.id=${data.originId}`);
        }

        if (queryParams.length > 0) {
            query += queryParams.join('&');
        }

        try {
            const response = await axios.get(query + `&_page=${currentPage}&_limit=${limit}`);
            console.log(response);

            const totalItems = parseInt(response.headers['x-total-count'], 10);
            dispatch({
                type: SEARCH_PIG,
                payload: response.data
            })

            dispatch({
                type: TOTAL_PAGES,
                payload: Math.ceil(totalItems / limit)
            })
        } catch (error) {
            console.error('Lỗi khi tìm kiếm:', error);
        }
    }
}