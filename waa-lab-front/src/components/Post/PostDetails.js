import axios from 'axios';
import React from 'react';

const PostDetails = ({ post, onDeletePost, onEditPost }) => {
  const handleDelete = () => {
    axios.delete(`http://localhost:8080/api/posts/${post.id}`)
      .then((response) => {
        console.log('Post deleted:', response.data);
        onDeletePost(post.id);
      })
      .catch((error) => {
        console.error('Error deleting post:', error);
      });
  };

  return (
    <div className="post-details">
      <h2>{post.title}</h2>
      <p><strong>Author:</strong> {post.author}</p>
      <p><strong>Content:</strong> {post.content}</p>
      <button onClick={() => onEditPost(post)}>Edit</button>
      <button onClick={handleDelete}>Delete</button>
    </div>
  );
};

export default PostDetails;
