import { useEffect } from "react";
import { useForm } from "react-hook-form";
import { useRecoilState, useSetRecoilState } from "recoil";
import { loginState, mainState } from "../store/atom";
import { apiPost } from "../util/api";
import { Box, Button, TextField } from "@mui/material";

const Login = () => {
  const setLoggedin = useSetRecoilState(loginState);
  const [mainData, setMainData] = useRecoilState(mainState);

  const { handleSubmit, register, setValue, errors, triggerValidation } = useForm();

  useEffect(() => {
    register({ name: "id" }, { required: true });
    register({ name: "pwd" }, { required: true });
  }, [register]);

  const onChange = async ({ target }) => {
    setValue(target.name, target.value);
    await triggerValidation(target.name);
  };
  const login = async (data) => {
    const res = await apiPost("/api/member/login", data);
    setLoggedin(res.data);
    if (res.data) {
      setMainData({ ...mainData, user: { userId: data.id } });
      setLoggedin(true);
    }
  };

  return (
    <div className="form-group">
      <Box component="form" size="large" onSubmit={handleSubmit(login)}>
        <TextField
          margin="normal"
          required
          // fullWidth
          id="id"
          label="ID"
          autoComplete="id"
          autoFocus
          icon="user"
          iconposition="left"
          placeholder="아이디"
          name="id"
          onChange={onChange}
          error={errors.id !== undefined}
          helperText={errors.id ? "아이디를 입력하세요" : ""}
        />

        <TextField
          icon="lock"
          required
          iconposition="left"
          label="Password"
          placeholder="비밀번호"
          name="pwd"
          type="password"
          onChange={onChange}
          error={errors.pwd !== undefined}
          helperText={errors.pwd ? "비밀번호를 입력하세요" : ""}
        />

        <Button type="submit">Login</Button>
      </Box>
    </div>
  );
};

export default Login;
