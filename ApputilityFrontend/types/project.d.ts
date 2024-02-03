declare namespace Project{
import { ProfileService } from 'service/ProfileService';
import { UserService } from 'service/UserService';
    
    //CustomerService
    type User = {
        id?: number;
        name?: string;
        loginName?: string;
        email: string;
        passwd?: string;
    };

    type Resource = {
        id?: number;
        name:string;
        key:string;
    }

    type Profile = {
        id?: number;
        description:string;
    }

    type UserProfile = {
        id?: number;
        user: User;
        profile: Profile;
    }
}