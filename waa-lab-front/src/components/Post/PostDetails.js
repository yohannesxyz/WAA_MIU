// PostDetails.js
import axios from 'axios';
import React, { useContext } from 'react';
import { SelectedPostContext } from '../../context/SelectedPostContext';


const PostDetails = ({ post, onDeletePost, onEditPost }) => {
  const { setSelectedPostId } = useContext(SelectedPostContext);

  const handleDelete = () => {
    axios.delete(`http://localhost:8080/api/posts/${post.id}`)
      .then((response) => {
        console.log('Post deleted:', response.data);
        onDeletePost(post.id);
        setSelectedPostId(null);
      })
      .catch((error) => {
        console.error('Error deleting post:', error);
      });
  };

  const handleEdit = () => {
    onEditPost(post);
  };

  return (
    <div className="post-details">
      <h2>{post.title}</h2>
      <p><strong>Author:</strong> {post.author}</p>
      <p><strong>Content:</strong> {post.content}</p>
      <button onClick={handleEdit}>Edit</button>
      <button onClick={handleDelete}>Delete</button>
    </div>
  );
};

export default PostDetails;
