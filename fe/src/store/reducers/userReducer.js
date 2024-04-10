
const initialState = {
    email:null,
    username:null,
    token:null,
    role:null,
    id:null
}

const LOG_IN = "LOG_IN";
const LOG_OUT = "LOG_OUT";

export const userReducer =(state = initialState,action)=>{
    switch(action.type){
        case LOG_IN:{
            const { email, username, token,role, id } = action.payload;
            return{...state,email,username,token,role,id};
        }
        case LOG_OUT:{
            return{...state,
                email:null,
                username:null,
                token:null,
                role:null,
                id:null}
        }
     



        default:
            return state;
    }
}