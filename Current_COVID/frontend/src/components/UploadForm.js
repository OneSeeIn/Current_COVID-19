import axios from "axios";
import { postFormState } from "../store/atom";
import { useEffect } from "react";
import { useForm } from "react-hook-form";
import { useRecoilState } from "recoil";
import { Box, Button, Input, Typography } from "@mui/material";
import { FileUpload } from "@mui/icons-material";

const UploadForm = () => {
  const { handleSubmit, register, setValue } = useForm();
  const [postForm, setPostForm] = useRecoilState(postFormState);
  useEffect(() => {
    register({ name: "files" });
    register({ name: "postTitle" });
    register({ name: "postContent" });
  }, [register]);
  const onChange = async ({ target }) => {
    target.name === "files" ? setValue(target.name, target.files) : setValue(target.name, target.value);
  };
  const onSubmit = async (e) => {
    const formData = new FormData();

    for (const file of e.files) {
      formData.append("files", file);
    }
    const postRequest = { userId: "jhsong", postTitle: e.postTitle, postContent: e.postContent };
    formData.append("postRequest", new Blob([JSON.stringify(postRequest)], { type: "application/json" }));
    const res = await axios.post("/api/post/postImg", formData);
    setPostForm(res.data);
  };
  return (
    <div className="form-group">
      <Box component="form" onSubmit={handleSubmit(onSubmit)}>
        <Button component="label">
          <Typography variant="button">{"파일 선택"}</Typography>
          <input name="files" multiple="multiple" type="file" onChange={onChange} hidden />
        </Button>
        <input name="postTitle" type="text" onChange={onChange} />
        <input name="postContent" type="text" onChange={onChange} />
        <Button variant="contained" type="submit">
          <FileUpload></FileUpload>upLoad
        </Button>
      </Box>
    </div>
  );
};

export default UploadForm;
