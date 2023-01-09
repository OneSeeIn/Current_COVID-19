import { useRecoilValue } from "recoil";
import { postFormState } from "../store/atom";

const PostForm = () => {
  const postData = useRecoilValue(postFormState);
  return (
    <div className="postData">
      <div>
        <span>{postData.title}</span>
      </div>
      <div>
        <span>{postData.contents}</span>
      </div>
      <div>
        {postData.postResourcesList.map((resource) => (
          <img key={resource.id} src={resource.resourceUrl} alt=""></img>
        ))}
      </div>
    </div>
  );
};

export default PostForm;
