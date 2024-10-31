import { FETCH_PIG_SUCCESS, FETCH_ORIGIN_SUCCESS, TOTAL_PAGES, SEARCH_PIG } from "./action";

const initialState = {
    pigs: [],
    origins: [],
    totalPages: 0,
}

const rootReducer = (state = initialState, action) => {
    switch (action.type) {
        case FETCH_PIG_SUCCESS:
            return { ...state, pigs: action.payload };
        case FETCH_ORIGIN_SUCCESS:
            return { ...state, origins: action.payload };
        case TOTAL_PAGES:
            return { ...state, totalPages: action.payload }
        case SEARCH_PIG:
            return { ...state, pigs: action.payload };
    }

    return state;
};

export default rootReducer;