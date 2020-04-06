import axios from "axios";


const USER_API_BASE_URL = process.env.REACT_APP_HOST_API_SERVICE;

class AuthService {

    login(data){
        return axios.post(USER_API_BASE_URL + "/login", data);
    }

    getUserInfo(){
        return JSON.parse(localStorage.getItem("userInfo"));
    }

    getAuthHeader() {
       return {headers: {Authorization: 'Bearer ' + this.getUserInfo().token }};
    }

    logOut() {
        localStorage.removeItem("userInfo");
        return axios.post(USER_API_BASE_URL + 'logout', {}, this.getAuthHeader());
    }
}

export default new AuthService();