
import React from 'react';
import { SelectedPostProvider } from './context/SelectedPostContext';
import Dashboard from './containers/Dashboard/Dashboard';

const App = () => {
  return (
    <SelectedPostProvider>
      <Dashboard />
    </SelectedPostProvider>
  );
};

export default App;
