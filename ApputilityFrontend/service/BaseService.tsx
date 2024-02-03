import axios from "axios";

export const axiosInstance = axios.create({
    baseURL: process.env.NEXT_PUBLIC_BACKEND_URL_API
})

export class BaseService{
    url:string;

    constructor(url:string){
        this.url = url;
    }

    // Método responsável por buscar todos os utilizadores.
    getAll(){
        return axiosInstance.get(this.url);
    }
    // Método responsável por buscar um utilizador pelo seu ID.
    getById(id: number){
        return axiosInstance.get(this.url + "/" + id);
    }

    // Método responsável por criar um novo utilizador.
    save(object: any){
        return axiosInstance.post(this.url, object);
    }

    // Método responsável por atualizar um utilizador.
    /* updateUser(user: User){
        return axiosInstance.put("/user/" + user.id, user);
    } */

    // Método responsável por atualizar um utilizador.
    update(object: any){
        return axiosInstance.put(this.url, object);
    }

    // Método responsável por excluir um utilizador.
    delete(id: number){
        return axiosInstance.delete(this.url + "/" + id);
    }
} 