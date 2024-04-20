
const initialState = {
    songs:[],
    currentPage:0,
    totalElements:0
}

const GET_SONGS = "GET_SONGS";
const CLEAR_SONGS = "CLEAR_SONGS";

export const songsReducer= (state = initialState,action)=>{
    switch(action.type){
        case GET_SONGS:
            {
                const {songs,currentPage,totalElements} = action.payload;
                return {...state,songs,currentPage,totalElements}
            }
        case CLEAR_SONGS:
            {
                const {songs,currentPage,totalElements} = action.payload;
                return {...state,songs,currentPage,totalElements}
            }
       
        default:
            return state;
    }

}