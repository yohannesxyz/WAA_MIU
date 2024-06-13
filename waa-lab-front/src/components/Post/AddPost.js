// AddPost.js
import React, { useRef } from 'react';
import axios from 'axios';


const AddPost = ({ onPostAdded }) => {
  const titleRef = useRef();
  const authorRef = useRef();
  const contentRef = useRef();

  const handleSubmit = (e) => {
    e.preventDefault();

    const newPost = {
      title: titleRef.current.value,
      author: authorRef.current.value,
      content: contentRef.current.value
    };

    axios.post('http://localhost:8080/api/posts', newPost)
      .then((response) => {
        onPostAdded(response.data);
        titleRef.current.value = '';
        authorRef.current.value = '';
        contentRef.current.value = '';
      })
      .catch((error) => {
        console.error('Error adding post:', error);
      });
  };

  return (
    <form className="add-post-form" onSubmit={handleSubmit}>
      <input
        type="text"
        ref={titleRef}
        placeholder="Title"
        required
      />
      <input
        type="text"
        ref={authorRef}
        placeholder="Author"
        required
      />
      <textarea
        ref={contentRef}
        placeholder="Content"
        required
      />
      <button type="submit">Add Post</button>
    </form>
  );
};

export default AddPost;
