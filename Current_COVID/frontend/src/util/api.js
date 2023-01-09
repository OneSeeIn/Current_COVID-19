import axios from "axios";

export function apiPost(url, data) {
  try {
    const response = axios.post(url, data);
    return response;
  } catch (error) {
    console.log(error);
    alert(error);
  }
}

export function apiGet(url, data) {
  //캐시 적용안함
  axios.defaults.headers.get["Pragma"] = "no-cache";
  axios.defaults.headers.get["Cache-Control"] = "no-cache, no-store";
  try {
    const response = axios.get(url, data);
    return response;
  } catch (error) {
    console.log(error);
    alert(error);
  }
}
