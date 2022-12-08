import axios from "axios";
import { useEffect } from "react";
import { useForm } from "react-hook-form";
import { useRecoilState } from "recoil";
import { Button, Form, Segment, Message } from "semantic-ui-react";
import { loginState } from "../store/atom";
import { apiPost } from "../util/api";

const Login = () => {
  const [loginInfo, setLogin] = useRecoilState(loginState);

  const { handleSubmit, register, setValue, errors, triggerValidation } = useForm();

  useEffect(() => {
    register({ name: "id" }, { required: true });
    register({ name: "pwd" }, { required: true });
  }, [register]);

  const onChange = async (e, { name, value }) => {
    setValue(name, value);
    await triggerValidation({ name });
  };
  const login = async (data) => {
    // e.preventDefault();
    const res = await apiPost("/api/member/login", data);
    console.log(res);
    setLogin(res.data);
  };
  return (
    <div className="form-group">
      <Form size="large" onSubmit={handleSubmit(login)} error>
        <Segment stacked>
          <Form.Input fluid icon="user" iconPosition="left" placeholder="아이디를 입력하세요" name="id" onChange={onChange} />
          <Form.Input fluid icon="lock" iconPosition="left" placeholder="비밀번호를 입력하세요" name="pwd" type="password" onChange={onChange} />
          <Message error content={(errors.id || errors.pwd) && "아이디 또는 비밀번호를 확인하세요"} />
          <Button type="submit" color="teal" fluid size="large">
            Login
          </Button>
        </Segment>
      </Form>
    </div>
  );
};

export default Login;
