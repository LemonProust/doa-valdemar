import axios from "axios";
import {BaseService} from "./BaseService";

export class UserProfileService extends BaseService {

    constructor(){
        super("/userprofile")
    }
}   