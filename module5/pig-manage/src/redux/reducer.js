import { FETCH_PIG_SUCCESS, FETCH_ORIGIN_SUCCESS } from "./action";

const initialState = {
    pigs: [],
    origins: []
}

const rootReducer = (state = initialState, action) => {
    switch (action.type) {
        case FETCH_PIG_SUCCESS:
            return { ...state, pigs: action.payload };
        case FETCH_ORIGIN_SUCCESS:
            return { ...state, origins: action.payload }
    }

    return state;
};

export default rootReducer;