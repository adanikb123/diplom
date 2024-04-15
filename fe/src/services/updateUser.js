import axios from "axios";

export const updateUser = async (user, token) => {
    const request = {
      name: user.name,
      email: user.email,
      role: user.role,
    };
    return await axios.patch(`http://localhost:8080/user/update/${user.id}`, request, {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`,
      },
    });
  };

