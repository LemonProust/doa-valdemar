import axios from "axios";
import {BaseService} from "./BaseService";

/* export const axiosInstance = axios.create({
    baseURL: "http://localhost:8080"
}) */

export class ResourceService extends BaseService {

    constructor(){
        super("/resource")
    }
}   