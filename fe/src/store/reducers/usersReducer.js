const initialState = {
    users:[],
    currentPage:0,
    totalElements:0
}


const GET_USERS  = "GET_USERS";
const UPDATE = "UPDATE"

export const usersReducer =(state = initialState,action)=>{
    switch(action.type){
        case GET_USERS:{
            const {users,currentPage,totalElements} = action.payload;
            return {...state,users,currentPage,totalElements}
        }
        case UPDATE:{
            const {users} = action.payload;
            return {...state,users}
        }
        default:
            return state;
    }
}