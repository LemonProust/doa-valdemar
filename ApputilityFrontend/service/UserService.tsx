import axios from "axios";

export const axiosInstance = axios.create({
    baseURL: "http://localhost:8080"
})

export class UserService{

    // Método responsável por buscar todos os utilizadores.
    getAllUsers(){
        return axiosInstance.get("/user");
    }
    // Método responsável por buscar um utilizador pelo seu ID.
    getUser(id: number){
        return axiosInstance.get("/user/" + id);
    }
    // Método responsável por criar um novo utilizador.
    saveUser(user: User){
        return axiosInstance.post("/user", user);
    }
    // Método responsável por atualizar um utilizador.
    /* updateUser(user: User){
        return axiosInstance.put("/user/" + user.id, user);
    } */

    // Método responsável por atualizar um utilizador.
    updateUser(user: User){
        return axiosInstance.put("/user", user);
    }

    // Método responsável por excluir um utilizador.
    deleteUser(id: number){
        return axiosInstance.delete("/user/" + id);
    }
}   

