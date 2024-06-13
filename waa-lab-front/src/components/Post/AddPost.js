import React, { useState } from 'react';
import axios from 'axios';

const AddPost = ({ onPostAdded }) => {
  const [title, setTitle] = useState('');
  const [author, setAuthor] = useState('');
  const [content, setContent] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();

    const newPost = { title, author, content };

    axios.post('http://localhost:8080/api/posts', newPost)
      .then((response) => {
        onPostAdded(response.data); // Notify the parent component to update the state
        setTitle('');
        setAuthor('');
        setContent('');
      })
      .catch((error) => {
        console.error('Error adding post:', error);
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
        placeholder="Title"
        required
      />
      <input
        type="text"
        value={author}
        onChange={(e) => setAuthor(e.target.value)}
        placeholder="Author"
        required
      />
      <textarea
        value={content}
        onChange={(e) => setContent(e.target.value)}
        placeholder="Content"
        required
      />
      <button type="submit">Add Post</button>
    </form>
  );
};

export default AddPost;
