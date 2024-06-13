// Dashboard.js
import React, { useEffect, useState, useContext } from 'react';
import axios from 'axios';
import Posts from '../../components/Post/Posts';
import PostDetails from '../../components/Post/PostDetails';
import AddPost from '../../components/Post/AddPost';
import EditPost from '../../components/Post/EditPost';
import { SelectedPostContext } from '../../context/SelectedPostContext';


const Dashboard = () => {
  const [posts, setPosts] = useState([]);
  const [title, setTitle] = useState('');
  const [editingPost, setEditingPost] = useState(null);
  const [reloadPosts, setReloadPosts] = useState(false);

  const { selectedPostId, setSelectedPostId } = useContext(SelectedPostContext);
  const selectedPost = posts.find(post => post.id === selectedPostId);

  useEffect(() => {
    loadPosts();
  }, [reloadPosts]);

  const loadPosts = () => {
    axios.get('http://localhost:8080/api/posts')
      .then((response) => {
        setPosts(response.data);
      })
      .catch((error) => {
        console.error('Error fetching posts:', error);
      });
  };

  const handleChangeTitle = () => {
    if (title.trim() === '') {
      return;
    }

    const updatedPosts = posts.map(post =>
      post.id === 1 ? { ...post, title: title } : post
    );
    setPosts(updatedPosts);
  };

  const handleSelectPost = (post) => {
    setSelectedPostId(post.id);
  };

  const handleDeletePost = (postId) => {
    setPosts(posts.filter(post => post.id !== postId));
    setSelectedPostId(null);
  };

  const handlePostAdded = (newPost) => {
    setPosts([...posts, newPost]);
    setReloadPosts(prev => !prev);
  };

  const handleEditPost = (post) => {
    setEditingPost(post);
  };

  const handleUpdatePost = (updatedPost) => {
    setReloadPosts(prev => !prev);
    setEditingPost(null);
    setSelectedPostId(updatedPost.id);
  };

  const handleCancelEdit = () => {
    setEditingPost(null);
  };

  return (
    <div className="container">
      <AddPost onPostAdded={handlePostAdded} />
      <Posts posts={posts} onSelectPost={handleSelectPost} />
      <input 
        type="text" 
        value={title} 
        onChange={(e) => setTitle(e.target.value)} 
        placeholder="Title" 
      />
      <button onClick={handleChangeTitle}>Change Title</button>
      {selectedPost && !editingPost && <PostDetails post={selectedPost} onDeletePost={handleDeletePost} onEditPost={handleEditPost} />}
      {editingPost && <EditPost post={editingPost} onUpdatePost={handleUpdatePost} onCancel={handleCancelEdit} />}
    </div>
  );
};

export default Dashboard;
