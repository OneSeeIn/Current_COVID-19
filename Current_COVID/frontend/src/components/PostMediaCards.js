import { useState } from "react";
import { useRecoilValue } from "recoil";
import { postFormState } from "../store/atom";

const PostMediaCards = (postResourcesList) => {
  const [curIndex, setCurIndex] = useState(0);

  const moveToNext = (arr, index) => {
    setCurIndex(curIndex + 1);
  };
  const moveToPrev = (arr, index) => {
    setCurIndex(curIndex - 1);
  };
  return (
    <div className="postMediaCards">
      <div onClick={moveToPrev}> {"<"} </div>
      {postResourcesList.map((resource) => (
        <div className="PostMediaCard">
          <img key={resource.id} src={resource.resourceUrl} alt=""></img>
        </div>
      ))}
      <div onClick={moveToNext}> {">"} </div>
    </div>
  );
};

export default PostMediaCards;
