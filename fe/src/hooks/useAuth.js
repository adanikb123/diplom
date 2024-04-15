import {useSelector} from "react-redux";

export const useAuth=()=>{
    const user = useSelector(state=>state.user);

    return {
        isAuth: Boolean(user.id),
        email:user.email,
        name:user.name,
        token:user.token,
        id:user.id,
        role:user.role
    }

}