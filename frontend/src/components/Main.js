import axios from "axios";
import { useEffect } from "react";
import { useForm } from "react-hook-form";
import { useRecoilState } from "recoil";
import { Button, Form, Segment, Message } from "semantic-ui-react";
import { loginState } from "../store/atom";
import { apiPost } from "../util/api";

const Main = () => {
  const { handleSubmit, register, setValue, errors, triggerValidation } = useForm();

  useEffect(() => {
    register({ name: "files" });
    register({ name: "postTitle" });
    register({ name: "postContent" });
  }, [register]);
  const onChange = async (e, { name, value }) => {
    console.log(name === "files");
    name === "files" ? setValue(name, e.target.files) : setValue(name, value);
  };
  const onSubmit = async (e) => {
    console.log(e);
    const files = [];
    const formData = new FormData();

    for (const file of e.files) {
      formData.append("files", file);
      // console.log(res.data.url);
      // const url = res.data.url;
      // document.getElementById("img").setAttribute("src", url);
    }
    console.log({ userId: "jhsong", postTitle: e.postTitle, postContent: e.postContent });
    formData.append("postRequest", { userId: "jhsong", postTitle: e.postTitle, postContent: e.postContent });
    debugger;
    const res = await axios.post("/api/cloud/postImg", formData);
  };
  return (
    <div>
      <div className="form-group" style={{ float: "left" }}>
        <Form size="large" onSubmit={handleSubmit(onSubmit)} error>
          <Form.Input name="files" multiple="multiple" type="file" onChange={onChange} />
          <Form.Input name="postTitle" type="text" onChange={onChange} />
          <Form.Input name="postContent" type="text" onChange={onChange} />
          <Button type="submit" color="teal" fluid size="large">
            upLoad
          </Button>
        </Form>
      </div>
      <div>
        aa
        <img id="img"></img>
      </div>
    </div>
  );
};

export default Main;
