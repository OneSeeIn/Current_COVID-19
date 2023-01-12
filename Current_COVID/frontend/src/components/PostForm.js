import { Avatar, Box, Card, CardActions, CardContent, CardHeader, CardMedia, IconButton, Typography } from "@mui/material";
import { useRecoilValue } from "recoil";
import { postFormState } from "../store/atom";
import { red } from "@mui/material/colors";
import { Favorite, FavoriteTwoTone, MoreVert, Share } from "@mui/icons-material";

const PostForm = () => {
  const postData = useRecoilValue(postFormState);
  return (
    <Card sx={{ maxWidth: 500, margin: "auto" }}>
      <CardHeader
        avatar={
          <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
            R
          </Avatar>
        }
        action={
          <IconButton aria-label="settings">
            <MoreVert />
          </IconButton>
        }
        title={postData.title}
        subheader={"" + new Date(postData.createDt)}
      />
      {postData.postResourcesList.map((resource) => {
        return (
          <CardMedia component="img" key={resource.id} sx={{ width: "300px", height: "300px", margin: "auto" }} src={resource.resourceUrl} alt="" />
        );
      })}
      <CardContent>
        <Typography variant="body2" color="text.secondary">
          {postData.contents}
        </Typography>
      </CardContent>
      <CardActions disableSpacing>
        <IconButton aria-label="add to favorites">
          <Favorite sx={{ color: red[500] }} />
        </IconButton>
        <IconButton aria-label="share">
          <Share />
        </IconButton>
      </CardActions>
    </Card>
  );
};

export default PostForm;
