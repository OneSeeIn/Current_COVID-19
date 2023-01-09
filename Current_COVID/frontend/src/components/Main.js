import { Button } from "@mui/material";
import { useRecoilState, useRecoilValue } from "recoil";
import { loginState, mainState } from "../store/atom";
import PostForm from "./PostForm";
import UploadForm from "./UploadForm";

const Main = () => {
  const mainData = useRecoilValue(mainState);

  const [isLoggedIn, setIsLoggedIn] = useRecoilState(loginState);

  const logoutHandler = () => {
    localStorage.removeItem("4242-token");
    setIsLoggedIn(false);
  };
  return (
    <div>
      <div stule={{ float: "right" }}>
        {mainData.user.userId} <Button onClick={logoutHandler}>로그아웃</Button>
      </div>
      <UploadForm></UploadForm>
      <PostForm></PostForm>
    </div>
  );
};

export default Main;
