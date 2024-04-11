import { useAuth } from '../../hooks/useAuth';
import { Navigate} from 'react-router-dom';
import {notification} from "antd"

export const RequireAuth=({ children })=>{
    const user = useAuth();

    const redirectToLogin = () => {
        notification.warning({
            message: 'Пожалуйста, войдите в систему',
            type:"warning",
            placement:"topLeft"
        });
        return <Navigate to="/login" />;
    };
    console.log(user.isAuth);
    return user.isAuth ?
    (
        <div>{children}</div> 
        
    ):
    (
        redirectToLogin()
    )
}