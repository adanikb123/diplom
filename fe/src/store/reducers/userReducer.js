const initialState = {
    email:null,
    name:null,
    token:null,
    role:null,
    id:null
}

const LOG_IN = "LOG_IN";
const LOG_OUT = "LOG_OUT";
const GET_USER = "GET_USER"
const UPDATE_NAME  = "UPDATE_NAME";
const UPDATE_ROLE  = "UPDATE_ROLE";
export const userReducer =(state = initialState,action)=>{

    switch(action.type){
        case LOG_IN:{
            const { email, name, token,role, id } = action.payload;
            return{...state,email,name,token,role,id};
        }
        case LOG_OUT:{
            const { email, name, token,role, id } = action.payload;
            return{...state,email,name,token,role,id};
        }
        case UPDATE_NAME:{
            console.log(action.payload)
           
            return {...state,name:action.payload};
        }
        case UPDATE_ROLE:{
           
            return {...state,role:action.payload};
        }
        case GET_USER:{
            const { email, name,role, id } = action.payload;
            return{...state,email,name,role,id};
        }
        default:
            return state;
    }
}
