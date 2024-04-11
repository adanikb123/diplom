
const initialState = {
    songs:[],
    currentPage:0,
    totalElements:0
}

const GET_SONGS = "GET_SONGS";

export const songReducer= (state = initialState,action)=>{
    switch(action.type){
        case GET_SONGS:
            const {songs,currentPage,totalElements} = action.payload;
            console.log(songs);
            return {...state,songs,currentPage,totalElements}
        default:
            return state;
    }

}