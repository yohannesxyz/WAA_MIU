import axios from 'axios';
import React, { useState } from 'react';

const EditPost = ({ post, onUpdatePost, onCancel }) => {
  const [title, setTitle] = useState(post.title);
  const [author, setAuthor] = useState(post.author);
  const [content, setContent] = useState(post.content);

  const handleSave = () => {
    const updatedPost = { ...post, title, author, content };
    
    axios.put(`http://localhost:8080/api/posts/${post.id}`, updatedPost)
      .then((response) => {
        onUpdatePost(response.data);
      })
      .catch((error) => {
        console.error('Error updating post:', error);
      });
  };

  return (
    <div className="edit-post">
      <h2>Edit Post</h2>
      <input 
        type="text" 
        value={title} 
        onChange={(e) => setTitle(e.target.value)} 
        placeholder="Title" 
      />
      <input 
        type="text" 
        value={author} 
        onChange={(e) => setAuthor(e.target.value)} 
        placeholder="Author" 
      />
      <textarea 
        value={content} 
        onChange={(e) => setContent(e.target.value)} 
        placeholder="Content" 
      />
      <button onClick={handleSave}>Save</button>
      <button onClick={onCancel}>Cancel</button>
    </div>
  );
};

export default EditPost;
