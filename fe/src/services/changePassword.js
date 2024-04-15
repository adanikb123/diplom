import axios from "axios";

export const changePassword = async (id,password) => {
    const requestData = { password: password }; // Создаем объект с полем password
    console.log(requestData);
    return await axios.patch(`http://localhost:8080/user/update/password/${id}`,requestData);
  };

